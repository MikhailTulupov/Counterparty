# Counterparty
Данное приложение выполнено как тестовое задание.</br>
Суть приложения Работа с контарагентами.</br>
</br>
Я опишу какие технологии я использовал для создания данного приложения. Ниже приведу Само здание </br>
</br>
<h2>Задание</h2>
Реализовать работу с контрагентами: добавление, удаление, редактирование.</br> 
<h3>У каждого должны быть следующие поля:</h3>
<ol>
  <li>Имя</li>
  <li>Контактный телефон</li>
  <li>Фотография (если отсутствует, отображать изображение на своё усмотрение)</li>
  <li>Email адрес (может отсутствовать)</li>
</ol></br>
Главная страница приложения должна отображать список контрагентов. </br>
Список должен быть отсортирован в алфавитном порядке (от А до Я).</br>
По нажатию на элемент списка должна открываться форма с подробной информацией об контрагенте,</br> 
на этой же форме можно отредактировать эту информацию.</br>
Расположение кнопок для удаления/добавления не принципиально.</br>
Для хранения данных использовать SQLite.</br>
Платформа: Android</br>
</br>
<h2>Используемые библиотеки:</h2>
<ul>
  <li>Room - предоставляет слой абстракции поверх SQLite, позволяющий получить свободный доступ к базе данных</li>
  <li>Navigation - предостовляет возможность взаимодействовать с фрагментами избавлясь от сложного шаблонного кода</li>
  <li>Coroutines - предостовляет возможность для создания запросов к базе данных вне основного потока, что делает код более лаконичным</li>
  <li>Timber - позволяет вести журнал</li>
  <li>Circle image view - предостовляет кастомное представление, которое закругляет изображение</li>
  <li>ViewModel - предостовляет возможность хранения и управления данными, связанными с пользовательским интерфейсом, с учетом жизненного цикла</li>
  <li>Result API - предостовяет возможность создать контрак для получение определенного контента например загрузка изображения из галереи</li>
</ul>
</br>
<h2>Возможности:</h2>
<ul>
  <li>Добавление контрагента</li>
  <li>Удаление контрагента</li>
  <li>Редактирование контрагента</li>
</ul>
<h2>Архитектура</h2>
Для создания приложения использовал архитектуру MVVM</br>
<img class="MMImage-Origin" src="https://miro.medium.com/max/960/0*-ZJZfLhup-7rg0cy.png">
</br>
<h2>Скриншоты приложения:</h2>
</br>
<h3>ListCounterpartyFragment</h3>
<img src="https://i.ibb.co/Rvn7FYv/Screenshot-1628221947.png" alt="Screenshot-1628221947" border="0">
</br>
<h3>DetailCounterpartyFragment</h3>
<img src="https://i.ibb.co/4Zv6DKj/Screenshot-1628221669.png" alt="Screenshot-1628221669" border="0">
</br>

