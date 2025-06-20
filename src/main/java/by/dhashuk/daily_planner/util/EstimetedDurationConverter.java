package by.dhashuk.daily_planner.util;

import java.time.Duration;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EstimetedDurationConverter implements AttributeConverter<Duration, Long> {

    @Override
    public Long convertToDatabaseColumn(Duration duration) {
        return duration == null ? null : Long.valueOf(duration.toSeconds());
    }

    @Override
    public Duration convertToEntityAttribute(Long duratiLong) {
        return duratiLong == null ? null : Duration.ofSeconds(duratiLong);
    }

}
