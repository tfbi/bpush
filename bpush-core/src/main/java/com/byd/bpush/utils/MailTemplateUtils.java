package com.byd.bpush.utils;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class MailTemplateUtils {
    private static final Configuration configuration = new Configuration();

    static {
        try {
            configuration.setClassForTemplateLoading(MailTemplateUtils.class, "/template");
            configuration.setTemplateLoader(new ClassTemplateLoader(MailTemplateUtils.class, "/template"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        configuration.setDefaultEncoding("utf-8");
    }

    public static String getContent(Map<String, Object> root, String sqlFileName) {
        try {
            Template template = configuration.getTemplate(sqlFileName);
            StringWriter out = new StringWriter();
            template.process(root, out);
            return out.getBuffer().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> root = new HashMap<>();
        root.put("code", "1234");
        String content = getContent(root, "mailTemplate.html");
        System.out.println(content);
    }
}
