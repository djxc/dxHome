package com.djxc.study.web.entity;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class EmailEntity {

    @NonNull
    @Email
    private String receiveEmail;

    @NonNull
    private String title;

    @NonNull
    private String content;
}
