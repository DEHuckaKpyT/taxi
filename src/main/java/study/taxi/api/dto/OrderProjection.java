package study.taxi.api.dto;

import lombok.*;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderProjection {

    UUID id;

    String createDateTime;

    String price;

    String type;

    String comment;
}
