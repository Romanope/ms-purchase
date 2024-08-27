package com.magazine.domain.purchase.validators;

import com.magazine.domain.common.InvalidDataException;

import java.time.LocalDate;

public class PurchaseYearValidator {

    private static final Integer MIN_YEAR = 1980;

    public static void validate(final Integer year) {

        if (year == null) {
            throw new InvalidDataException("the year is required");
        }

        if (year < MIN_YEAR) {
            throw new InvalidDataException("the year is invalid");
        }

        final int currentYear = LocalDate.now().getYear();
        if (year > currentYear) {
            throw new InvalidDataException("the year is invalid");
        }

    }
}
