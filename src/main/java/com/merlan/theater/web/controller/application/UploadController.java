package com.merlan.theater.web.controller.application;
/**
 * @author meilan_xie
 */

import com.merlan.theater.business.service.UserService;
import com.merlan.theater.data.entity.User;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value="/upload")
public class UploadController {
    public static final String uploadingdir = System.getProperty("user.dir") + "/uploadingdir/";
    public static final DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY/MM/DD");
    @Autowired
    private UserService userService;
    @RequestMapping("/uploading")
    public String uploading(Model model) {
        File file = new File(uploadingdir);
        model.addAttribute("files", file.listFiles());
        return "uploading";
    }
    @RequestMapping(value = "/uploaded", method = RequestMethod.POST)
    public String uploadingCsvPost(@RequestParam("uploadingFiles") MultipartFile[] uploadingFiles) throws IOException {
        List<String> emails = new ArrayList();
        String destStr = "redirect:/user/byEmails?emails=";
        for(MultipartFile uploadedFile : uploadingFiles) {
            File file = new File(uploadingdir + uploadedFile.getOriginalFilename());

            CSVParser records = CSVFormat.EXCEL.parse(new InputStreamReader(uploadedFile.getInputStream()));
            for (CSVRecord csvRecord : records) {
                User user = new User();
                user.setFirstName(csvRecord.get(0));
                user.setLastName(csvRecord.get(1));
                user.setEmail(csvRecord.get(2));
                user.setBirthday(new Date(fmt.parseMillis(csvRecord.get(3))));
                user.setNumberOfTickets(Integer.valueOf(csvRecord.get(4)).intValue());
                userService.saveUser(user);
                destStr = destStr + user.getEmail() + ",";
            }
            uploadedFile.transferTo(file);
        }

        return destStr + "";
}
}
