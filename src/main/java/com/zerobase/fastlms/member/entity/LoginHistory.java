package com.zerobase.fastlms.member.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * TODO : 로그인 히스토리 엔티티 구현
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class LoginHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Member member;

    private LocalDateTime loginDt;
    private String ip;
    private String userAgent;
}
