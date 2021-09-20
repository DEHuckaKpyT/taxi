package study.taxi.api.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarTypeDto {

    UUID typeId;
    String typeName;
}
