package ru.neoflex.practice.database;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "DatabaseRes")
public class DatabaseRes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private int ID;

    @Column(name = "first_number")
    private int firstNum;

    @Column(name = "action")
    private String action;

    @Column(name = "second_number")
    private int secondNum;

    @Column(name = "result")
    private int result;

    public DatabaseRes(int firstNum, String action, int secondNum, int result) {
        this.firstNum = firstNum;
        this.action = action;
        this.secondNum = secondNum;
        this.result = result;
    }
}
