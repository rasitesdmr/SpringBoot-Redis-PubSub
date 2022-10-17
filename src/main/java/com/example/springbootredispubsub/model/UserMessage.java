package com.example.springbootredispubsub.model;


import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserMessage {

    private String Message;
    private String author;

    @Override
    public String toString() {
        return "UserMessage{" +
                "Author='" + author + '\'' +
                "  , Message='" + Message + '\'' +
                '}';
    }
}
