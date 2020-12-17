package org.example.cloud.api_response;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessagesUtil {
    private static MessageSource messageSource;

    public MessagesUtil(MessageSource messageSource) {
        MessagesUtil.messageSource = messageSource;
    }
    /**
     * 获取单个国际化翻译值
     */
    public static String get(String msgKey) {
        try {
            return messageSource.getMessage(msgKey, null, LocaleContextHolder.getLocale());
        } catch (Exception e) {
            System.out.println(e);
            return msgKey;
        }
    }

}
