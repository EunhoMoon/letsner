package com.janek.letsner.domain.lesson;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LessonType {
    REGULAR("정규"), SUPPLEMENTARY("보강");

    private final String description;
}
