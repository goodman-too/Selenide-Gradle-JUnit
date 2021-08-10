#language:ru
#encoding:UTF-8

@test @login
Функционал: Проверка авторизации пользователя

  @positive
  Сценарий: Проверка логина с корректными данными
    Допустим открыта страница "https://www.saucedemo.com/"
    И имеется поле "Username"
    И имеется поле "Password"
    И пользователь вводит логин "standard_user"
    И пользователь вводит пароль "secret_sauce"
    И пользователь нажимает кнопку "Login"
    Тогда открывается страница "https://www.saucedemo.com/inventory.html"

  @negative
  Структура сценария: Проверка логина с некорректными данными
    Допустим открыта страница "https://www.saucedemo.com/"
    И имеется поле "Username"
    И имеется поле "Password"
    И пользователь вводит логин "<login>"
    И пользователь вводит пароль "<password>"
    И пользователь нажимает кнопку "Login"
    Тогда появляется ошибка авторизации

    Примеры:
      | login  | password |
      | qwerty | qwertyy  |
      | 123asd | 123asd   |
      | zzxxcc | zzxxcc   |

  @positive
  Сценарий: Проверка выхода из учетной записи
    Допустим открыта страница "https://www.saucedemo.com/"
    И имеется поле "Username"
    И имеется поле "Password"
    И пользователь вводит логин "standard_user"
    И пользователь вводит пароль "secret_sauce"
    И пользователь нажимает кнопку "Login"
    Тогда открывается страница "https://www.saucedemo.com/inventory.html"
    И пользователь нажимает кнопку меню
    И пользователь нажимает кнопку LogOut
    Тогда открывается страница "https://www.saucedemo.com/"