package com.visionrent.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="t_imagefile")
public class ImageFile {

    @Id
    @GeneratedValue(generator = "uuid") //12 karakterlik String bir id
    @GenericGenerator(name = "uuid", strategy="uuid2")
    private String id;

    private String name;

    private String type;

    private long length;

    @OneToOne(cascade = CascadeType.ALL) // ImageFile silinirse, imageData da silinsin
    private ImageData imageData;

    public ImageFile(String name, String type, ImageData imageData) {
        this.name = name;
        this.type = type;
        this.imageData = imageData;
        this.length = imageData.getData().length; // ImageFile uzunluğu imageData dan çekiliyor
    }
}
