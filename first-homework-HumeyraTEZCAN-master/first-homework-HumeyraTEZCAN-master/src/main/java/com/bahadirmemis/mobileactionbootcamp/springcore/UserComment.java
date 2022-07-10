package com.bahadirmemis.mobileactionbootcamp.springcore;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import com.bahadirmemis.mobileactionbootcamp.springcore.User;

@Entity
@Getter
@Setter
@Table(name = "USER_COMMENT_TABLE")
@AllArgsConstructor
@NoArgsConstructor
public class UserComment {


    @Id
    @SequenceGenerator(name ="User_Comment", sequenceName = "USER_COMMENT_ID_SEQ")
    @GeneratedValue(generator = "USER_COMMENT")
    private Long id;

    @Column(name = "COMMENT_User", length = 500, nullable = false)
    private String comment;

    @ManyToOne(fetch = FetchType.EAGER) //LAZY ile denediğimde olmadı
    @JoinColumn(name = "User_for_comment", nullable = false)
    private User user;

    @Column(name = "PRODUCT_ID", nullable = false)
    private Long productId;


    @Temporal(TemporalType.TIMESTAMP)
    private Date commentDate;

}
