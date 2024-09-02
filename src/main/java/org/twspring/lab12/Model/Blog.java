package org.twspring.lab12.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "VARCHAR(25) NOT NULL UNIQUE")
    @NotEmpty(message = "Title cannot be empty")
    @Size(min = 4,max = 25,message = "Title must have between 4 to 25 characters")
    private String title;

    @Column(columnDefinition = "VARCHAR(3000) NOT NULL")
    @NotEmpty(message = "Body cannot be empty")
    @Size(min = 20,max = 30000,message = "Body must have between 20 to 3000 characters")
    private String body;

    //Extra for a little practice
    @Column(columnDefinition = "BOOLEAN NOT NULL")
    @NotNull(message = "Is Marked As Mature Content cannot be null")
    private boolean isMarkedAsMatureContent; //content not appropriate to users under the age of 15

    //Relationships
    @ManyToOne
    @JsonIgnore
    private User author;

}
