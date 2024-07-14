package com.hour.carmedy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChatResponseModel
{

    private String id;
    private String object;
    private Long created;
    private String model;
    private Choice[] choices;
    private Usage usage;
    private String fingerprint;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Choice
    {
        private int index;
        private Message message;
        private String logprobs;
        private String finish_reason;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class Message
        {
            private String role;
            private String content;
            private String refusal;
        }

    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Usage
    {
        private int prompt_tokens;
        private int completion_tokens;
        private int total_tokens;
    }


}