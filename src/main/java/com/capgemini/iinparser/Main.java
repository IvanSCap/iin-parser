package com.capgemini.iinparser;

import com.capgemini.iinparser.domain.exception.PanFormatException;
import com.capgemini.iinparser.util.FormatUtil;
import lombok.extern.slf4j.Slf4j;

import javax.naming.ConfigurationException;
import java.io.IOException;

import static com.capgemini.iinparser.domain.constants.AppConstants.DEFAULT_PAN;

@Slf4j
public class Main {

    public static void main(String[] args) {
        String pan = getPan(args);

        try {
            FormatUtil formatter = new FormatUtil();
            String formattedPan = formatter.format(pan);
            log.info(formattedPan);
        } catch (PanFormatException | IOException | ConfigurationException e) {
            log.error(e.getMessage(), e);
        }
    }

    public static String getPan(String[] args) {
        if (args.length > 0) {
            return args[0];
        } else {
            log.info("No pan was found. Default pan will be used ({})", DEFAULT_PAN);
            return DEFAULT_PAN;
        }
    }
}
