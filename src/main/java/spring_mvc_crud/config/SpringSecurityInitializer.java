package spring_mvc_crud.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer {

    //пустой класс, использующийся для резистрации модуля в спринг-контейнере
    //Ключевым элементом Spring Framework является Spring Container.
    // Container создаёт объекты, связывает их вместе,
    // настраивает и управляет ими от создания до момента уничтожения.
    // Для управления компонентами, из которых состоит приложение,
    // Spring Container использует Внедрение Зависимостей (DI).

//    В этом контексте контейнер имеет значение чего-то, что обеспечивает инфраструктуру,
//    необходимую некоторым компонентам для жизни.
//    Вы можете представить себе это так:
//    Например, JVM-это контейнер для запуска программ Java,
//    Контейнер сервлетов (т. е. Tomcat) - это то, что запускает сервлеты
//    Контейнер EJB - это среда, в которой живет EJB
//    Точно так же Spring-это контейнер, в котором живут Spring Боба.
}
