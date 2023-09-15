package ex05_jstl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BlogPost {
  private int blogPostNo;
  private String title;
  private int hit;
  private BlogPost createdAT;


}
