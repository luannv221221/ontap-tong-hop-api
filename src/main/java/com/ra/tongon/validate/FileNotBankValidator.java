package com.ra.tongon.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

public class FileNotBankValidator implements ConstraintValidator<FileNotBank, MultipartFile> {

    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext constraintValidatorContext) {
        return file != null && !file.isEmpty();
    }
}
