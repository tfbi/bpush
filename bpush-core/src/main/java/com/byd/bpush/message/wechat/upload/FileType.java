package com.byd.bpush.message.wechat.upload;

/**
 * 上传的文件类型
 */
public enum FileType {
    IMAGE("图片", "image"),
    VOICE("语音", "voice"),
    VIDEO("视频", "video"),
    file("普通文件", "file");

    private final String type;

    public String getType() {
        return type;
    }

    FileType(String name, String type) {
        this.type = type;
    }
}
