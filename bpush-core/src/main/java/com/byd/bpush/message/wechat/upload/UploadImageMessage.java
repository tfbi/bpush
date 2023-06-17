package com.byd.bpush.message.wechat.upload;

import cn.hutool.core.io.FileUtil;
import com.byd.bpush.message.common.BaseMessage;
import com.byd.bpush.message.common.MessageType;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class UploadImageMessage extends BaseMessage {

    private final File file;
    private final String filePath;

    private UploadImageMessage(Builder builder) {
        file = builder.file;
        filePath = builder.filePath;
        messageType= MessageType.WECHAT_UPLOAD_IMAGE;
    }

    @Override
    public Map<String, Object> getCoreMap() {
        HashMap<String, Object> paramMap = new HashMap<>();
        if (file != null) {
            paramMap.put("file", file);
        } else {
            paramMap.put("file", FileUtil.file(filePath));
        }
        return paramMap;
    }

    public static final class Builder {
        private File file;
        private String filePath;


        public Builder() {
        }

        public Builder file(File val) {
            file = val;
            return this;
        }

        public Builder filePath(String val) {
            filePath = val;
            return this;
        }

        public UploadImageMessage build() {
            return new UploadImageMessage(this);
        }
    }
}
