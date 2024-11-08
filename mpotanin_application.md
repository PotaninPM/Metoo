# Потанин Михаил - Проект "Metoo"

> Приложение для управления и отслеживания событий на карте и не только. Предназначено для людей всех возрастов и профессиональных организаторов мероприятий.

#### Группа 10-И-1

#### Электронная почта: potaninpm@gmail.com

#### Telegram: @potaninpm

---
## Проблемное поле

С ростом числа общественных, культурных и экологических мероприятий в городах, возникает потребность в удобных и функциональных платформах для их организации и участия. На данный момент существующие решения имеют ряд значительных ограничений:

1. **Отсутствие визуализации на карте**: многие сервисы не предоставляют удобную карту, отображающую ближайшие события, что затрудняет пользователям поиск и планирование маршрута к мероприятиям.
    
2. **Недостаток мероприятий для решения экологических проблем**: в условиях возрастающих проблем загрязнения и недостатка экологических инициатив, пользователи не всегда могут найти доступные мероприятия, где они могли бы внести свой вклад в улучшение окружающей среды.
    
3. **Социализация и вовлечённость**: многим людям трудно находить единомышленников и участвовать в социальных и развлекательных мероприятиях, особенно в новых местах или при ограниченной информации. Это затрудняет развитие социальных связей и активное участие в жизни сообщества.
    
4. **Отсутствие гибкости и персонализации**: существующие платформы редко учитывают разнообразие тематик, таких как развлечение, эко-события, волонтёрство и помощь, и не позволяют гибко выбирать или фильтровать мероприятия по этим направлениям.

**Предлагаемое решение** направлено на устранение этих проблем путём создания удобного Android-приложения, которое объединит события различных тематик на одной платформе, обеспечит визуализацию на карте и упростит пользователям доступ к мероприятиям, соответствующим их интересам и предпочтениям.

---

## Целевая аудитория / заказчик

Программный продукт может заинтересовать широкую аудиторию, но мы выделили несколько ключевых групп пользователей:
- **Молодёжь и активные горожане** - пользователи, которые активно интересуются событиями в городе, особенно развлекательными мероприятиями, ищут способы интересно провести время с друзьями, семьей или новыми знакомыми.
- **Экологически осознанные люди** - аудитория, которая поддерживает инициативы по защите природы и улучшению экологии. Это могут быть волонтёры, студенты экологических и социальных направлений, и просто неравнодушные граждане..
- **Компании друзей** - они часто ищут варианты для культурного отдыха и развлечений, особенно в выходные или праздничные дни, и могут быть заинтересованы в мероприятиях, где можно провести время в кругу семьи и друзей.

---

## Аппаратные / программные требования

Продукт разрабатывается для операционной системы Android:

- **Android**: версия Nougat (Android 7)

---

## Функциональные требования

Приложение будет включать следующие функции:

1. **Создание и управление событиями**: возможность создания, редактирования и удаления событий.
2. **Отслеживание событий на карте**: визуализация местоположения событий.
3. **Возможность видеть друзей на карте**: все ваши друзья будут показываться на карте в реальном времени.
4. **Уведомления и напоминания**: напоминания о предстоящих событиях.
5. **Интеграция с Google Maps**: использование API Google Maps.
6. **Рейтинг пользователей**: рейтинг пользователей в реальном времени.

---

## Похожие / аналогичные продукты

Наше приложение будет выгодно отличаться от существующих продуктов:

 - **Blink**: это приложение сфокусировано на социальной сети и обмене сообщениями, но не предоставляет поддержку событийного контента. В Blink невозможно найти или организовать мероприятия, как в специализированных сервисах по анонсу событий. Приложение также не интегрировано с облачными сервисами для экспорта данных, что затрудняет обмен информацией за пределами платформы.

 - **Zenly**: одно из самых популярных ранее приложений для общения и отслеживания местоположения друзей, Zenly предоставлял пользователям карту с возможностью видеть местоположение своих друзей в реальном времени, но прекратил работу в 2023 году. Вследствие этого пользователи, привыкшие к функциям отслеживания друзей и визуализации на карте, столкнулись с нехваткой подобных возможностей на рынке.

 - **Яндекс Афиша**: сервис для поиска событий, который предоставляет пользователям возможность узнать о мероприятиях в их регионе и приобрести билеты. Однако Яндекс Афиша ограничен в возможностях взаимодействия: пользователи не могут создавать собственные мероприятия, приглашать друзей напрямую через приложение или видеть, кто из друзей посетит событие, что снижает социальную составляющую сервиса.

---

## Инструменты разработки и информация о базе данных

- **Android**: Kotlin / Jetpack Compose / Android Studio
- **Сервер**: Ktor
- **База данных**: PostgreSQL

<p>
    <img height=40 alt="kotlin" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/kotlin/kotlin-original.svg" />
    <img width="12" />
    <img height=40 alt="jetpack compose" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/jetpackcompose/jetpackcompose-original.svg" />
    <img width="12" />
    <img height=40 alt="ktor" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/ktor/ktor-original.svg" />
    <img width="12" />
    <img height=40 alt="postfresql" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/postgresql/postgresql-original.svg" />
</p>

---

## Этапы разработки

- [x] Проектирование интерфейса в Figma
- [ ] Создание сервера
- [ ] Написание интерфейса на Jetpack Compose
- [ ] Интеграция с API Google Maps
- [ ] Тестирование и отладка

---

## Возможные риски и пути их преодоления

#### Риски:
- Невозможность интеграции с Google Maps
- Нехватка времени на изучение необходимых технологий
#### Пути их преодоления:
- Использование API Yandex Maps
- Выделение большего времени на разработку продукта
---
