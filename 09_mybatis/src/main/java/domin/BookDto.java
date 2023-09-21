package domin;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BookDto {
  private int bookNo;
  private String author;
  private String title;
  private int price;
  private Date pubdate;
  
}
