package com.janek.letsner.infrastructure.schedule;

import com.janek.letsner.domain.schedule.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
