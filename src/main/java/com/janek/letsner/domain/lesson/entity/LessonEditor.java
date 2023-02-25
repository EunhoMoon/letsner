package com.janek.letsner.domain.lesson.entity;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class LessonEditor {

    private final LocalDate lessonDate;
    private final LocalTime lessonTime;

    public LessonEditor(LocalDate lessonDate, LocalTime lessonTime) {
        this.lessonDate = lessonDate;
        this.lessonTime = lessonTime;
    }

    public static LessonEditorBuilder builder() {
        return new LessonEditorBuilder();
    }

    public static class LessonEditorBuilder {
        private LocalDate lessonDate;
        private LocalTime lessonTime;

        LessonEditorBuilder() {}

        public LessonEditorBuilder lessonDate(final LocalDate lessonDate) {
            if (lessonDate != null) {
                this.lessonDate = lessonDate;
            }
            return this;
        }

        public LessonEditorBuilder lessonTime(final LocalTime lessonTime) {
            if (lessonTime != null) {
                this.lessonTime = lessonTime;
            }
            return this;
        }

        public LessonEditor build() {
            return new LessonEditor(this.lessonDate, this.lessonTime);
        }

        @Override
        public String toString() {
            return "LessonEditorBuilder{" +
                    "lessonDate=" + lessonDate +
                    ", lessonTime=" + lessonTime +
                    '}';
        }
    }

}
