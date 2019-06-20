# Документация игры Roguelike

## Команда
- Рябушев Антон
- Артемьева Ирина


## Общие сведения о системе
Компьютерная игра в жанре RogueLike.
Жанр характеризуется:
- Простой тайловой или консольной графикой
- Активным использованием случайной генерации
- Перманентной смертью персонажа и невозможностью загрузить предыдущее сохранение
- Чрезвычайно развитым набором игровых правил
- Высокой свободой действий персонажа (“игры-песочницы”)


## Architectural drivers

### Функциональные требования
- Персонаж игрока способен перемещается по карте; управление с клавиатуры
- Карта генерируется "на лету", но может грузиться и из файла
- Характеристики:
  - здоровье - сила атаки моба для победы над игроком
  - сила атаки - размер урона мобу при одном ударе
  - XP - опыт - количество шагов, сделанных игроком
  - уровень игрока - зависит от количества шагов, сделанных игроком: уровень повышается на 1 каждые 10 шагов
- Персонаж может использовать инвентарь для временного изменения своих характеристик:
  - броня/одежда/обувь
  - оружие
  - артефакты
- Есть несколько видов мобов, способных перемещаться по карте:
  - агрессивные - ходят за игроком
  - трусливые - убегают от игрока
  - пассивные - стоят на месте
- Боевая система: движущиеся объекты, пытающиеся занять одну клетку карты, атакуют друг друга

### Бизнес-ограничения
- Команда из двух человек
- Отсутствие финансовой поддержки
- Занятость сотрудников составляет 7 часов в неделю
- Сроки выполнения - 2 месяца

### Качественные характеристики системы
- Отсутствие ручного тестирования
- Отсутствие ревью кода

### Технические ограничения
- Исходники на Java, которые необходимо собрать
- 1 пользователь

## Роли и случаи использования
![useCaseDiagram](docs/useCaseDiagram.png)


## Композиция (диаграмма компонентов)
![componentDiagram](docs/componentDiagram.png)


## Логическая структура (диаграмма классов)
![classDiagram](docs/classDiagram.png)

## Взаимодействия и состояния (диаграммы последовательностей и конечных автоматов)
