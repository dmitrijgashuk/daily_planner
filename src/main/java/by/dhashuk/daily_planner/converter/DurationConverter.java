package by.dhashuk.daily_planner.converter;

import java.math.BigDecimal;
import java.time.Duration;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class DurationConverter implements AttributeConverter<Duration,BigDecimal> {

    @Override
    public BigDecimal convertToDatabaseColumn(Duration attribute) {
        return attribute == null ? null : BigDecimal.valueOf(attribute.getSeconds());
    }

    @Override
    public Duration convertToEntityAttribute(BigDecimal dbData) {
        return dbData == null ? null : Duration.ofSeconds(dbData.longValue());
    }

}
