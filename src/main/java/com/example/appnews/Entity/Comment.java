package com.example.appnews.Entity;


import com.example.appnews.Template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends AbsEntity {

    @Column(nullable = false, columnDefinition = "text")
    private String text;
    @ManyToOne (fetch = FetchType.LAZY)
    private Post post;
}
