# Практика "Создание клиент-серверного приложения"
## _**Задание №1 -  Создание контроллера**_ 

<br>
В папке src/main/java/ru/neoflex/practice создаю папку controller. В ней (/controller) создаём файл CalcController.java <br>
Над классом указываем аннотацию @RestController<br>
Создаём 2 public метода с аннотациями @GetMapping("/plus/{a}/{b}") и @GetMapping("/minus/{a}/{b}"), которые принимают 2 аргумента, типа Integer, а возвращают их сумму/разность соответственно. Перед каждым аргументом метода необходимо поставить @PathVariable("<a или b соответственно для каждого аргумента>")
<br>
  
```
package ru.neoflex.practice.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcController {
    @GetMapping("/plus/{a}/{b}")
    public Integer Sum (@PathVariable("a") Integer a, @PathVariable("b") Integer b){
        return a+b;
    }
    @GetMapping("/minus/{a}/{b}")
    public Integer Min(@PathVariable("a") Integer a, @PathVariable("b") Integer b){
        return a-b;
    }
}
```
<br>
Запускаем сервис, по зеленой кнопке сверху справа в окне Intellij IDEA <br>
Тестируем своё приложение по адресу http://localhost:8080/<адрес_и_параметры_для_2х_созданных_АПИ> <br>