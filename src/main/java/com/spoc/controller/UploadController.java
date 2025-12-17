package com.spoc.controller;

import com.spoc.common.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/common")
public class UploadController {

    @Value("${spoc.upload.path}")
    private String uploadPath;

    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) {
        if (file.isEmpty()) {
            return Result.error("上传文件不能为空");
        }

        // 1. 生成唯一文件名，防止覆盖 (uuid.mp4)
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString() + suffix;

        // 2. 确保目录存在
        File dir = new File(uploadPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // 3. 保存文件
        try {
            file.transferTo(new File(dir.getAbsolutePath() + File.separator + newFileName));

            // 4. 返回可访问的 URL (假设后端端口是 8080)
            // 实际生产中这里应该是域名，开发环境用相对路径或完整 localhost 路径
            String fileUrl = "http://localhost:8080/files/" + newFileName;
            return Result.success(fileUrl);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.error("文件上传失败: " + e.getMessage());
        }
    }
}