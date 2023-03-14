package com.capgemini.iinparser.util;

import com.capgemini.iinparser.domain.exception.PanFormatException;
import com.capgemini.iinparser.model.IinRange;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.capgemini.iinparser.domain.constants.AppConstants.CONFIG_FILE_PATH;

@Slf4j
public class FormatUtil {

    private final List<IinRange> iinRanges;
    private final IinUtil iinUtil;

    public FormatUtil() throws IOException {
        this.iinRanges = readConfigFile();
        iinRanges.sort(Collections.reverseOrder());
        iinUtil = new IinUtil();
    }

    public String format(String pan) throws PanFormatException {
        Optional<IinRange> matchingRange = iinRanges.stream()
                .filter(range -> iinUtil.matches(pan, range))
                .findFirst();
        return matchingRange.map(range -> iinUtil.formatPan(pan, range))
                .orElseThrow(() -> new PanFormatException("Unsupported PAN format: " + pan));
    }

    private static List<IinRange> readConfigFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(CONFIG_FILE_PATH))) {
            return reader.lines()
                    .map(line -> line.split(","))
                    .filter(parts -> !parts[0].contains("Issuer Name"))
                    .map(parts -> new IinRange(
                            parts[0],
                            Integer.parseInt(parts[1]),
                            Integer.parseInt(parts[2]),
                            Integer.parseInt(parts[3]),
                            Integer.parseInt(parts[4]),
                            parts[5]
                    ))
                    .collect(Collectors.toList());
        }
    }
}