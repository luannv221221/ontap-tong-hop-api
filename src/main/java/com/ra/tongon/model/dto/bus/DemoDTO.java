package com.ra.tongon.model.dto.bus;

import com.ra.tongon.validate.FileNotBank;
import org.springframework.web.multipart.MultipartFile;

public class DemoDTO {
    @FileNotBank(message = "File ko duoc rong")
    private MultipartFile demoImage;
}
