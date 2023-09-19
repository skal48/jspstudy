package common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data     // getter setter 모두 포함 
public class ActionForward {
  private String path; // 어디로 갈 것인가?
  private boolean isRedirect; //redirect는 true, forward 는 false
}
