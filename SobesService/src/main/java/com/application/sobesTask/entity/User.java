package com.application.sobesTask.entity;


import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

@Data
@Entity
@Builder
@Table(name = "user_relations", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    private Integer index;

    @Type(type = "jsonb")
    @Column(name = "relation", columnDefinition = "jsonb")
    @Basic
    private List<Integer> relation;
}
