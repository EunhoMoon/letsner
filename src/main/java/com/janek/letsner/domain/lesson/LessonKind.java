package com.janek.letsner.domain.lesson;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LessonKind {
    ACADEMY("학원 레슨"),
    PRIVATE("개인 레슨"),
    GROUP("그룹 레슨"),
    ONLINE("온라인 레슨"),
    SPECIAL("특강");

    private final String description;
}
