package com.janek.letsner.application.facade;

import com.janek.letsner.api.lesson.LessonDto;
import com.janek.letsner.common.annotations.UseCase;
import com.janek.letsner.domain.lesson.LessonService;
import com.janek.letsner.domain.user.UserService;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class UserLessonUseCase {

    private final UserService userService;

    private final LessonService lessonService;

    public void createNewUsersLesson(String userToken, LessonDto.Create lessonCreate) {
        var findUser = userService.getUserByToken(userToken);
        var newLesson = lessonCreate.toLesson(findUser);

        lessonService.createNewLesson(newLesson);
    }

}
