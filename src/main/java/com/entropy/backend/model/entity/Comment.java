package com.entropy.backend.model.entity;

import com.entropy.backend.model.enumeration.StatusType;
import com.entropy.backend.model.entity.base.Base;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends Base {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String content;
    @Column(name = "file_url")
    private String fileUrl;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "post_id")
    private Integer postId;
    @Column(name = "status_type")
    @Enumerated(value = EnumType.STRING)
    private StatusType statusType = StatusType.ON;
}
