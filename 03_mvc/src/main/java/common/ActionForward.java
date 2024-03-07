package common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ActionForward {
  private String view;
  private boolean isRedirect; // 객체의 필드는 기본값을 가진다. boolean:false
}
