# ☄️ Asteroid Monitor

_Egy modern, Java alapú REST backend szolgáltatás, amely a NASA NEO API-jából nyeri az adatokat._

![Java](https://img.shields.io/badge/-Java-blue?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/-SpringBoot-success?style=for-the-badge)
![REST API](https://img.shields.io/badge/-REST%20API-lightgrey?style=for-the-badge)
![Framer](https://img.shields.io/badge/-Framer-purple?style=for-the-badge)

---

> ⚠️ **Fontos megjegyzés:**
>
> Az alkalmazás frontendje **csak akkor működik webes felületen**, ha a Java backend éppen fut a fejlesztő gépén (`localhost:8081`).  
> **Postman segítségével viszont a backend funkciók bármikor tesztelhetők**, függetlenül a frontendtől.

---

## 🧭 Tartalomjegyzék

- [Áttekintés](#áttekintés)
- [Technológiák](#technológiák)
- [Használat](#használat)
- [Tesztelés Postmanben](#tesztelés-postmanben)
- [Futtatás](#futtatás)

---

## 🔍 Áttekintés

Az **Asteroid Monitor** egy Java Spring Boot alapú backend, amely a NASA által nyilvánosan elérhető Near Earth Object (NEO) API-ból kér le adatokat megadott dátumtartomány alapján. A visszakapott adatokat strukturált DTO-kon keresztül szolgáltatja tovább, JSON formátumban.

A cél, hogy könnyen beolvasható, rendezett információt adjunk az űrben mozgó potenciálisan veszélyes objektumokról (aszteroidák), kiegészítve egy látványos frontenddel (Framer/React alapon).

---

## 🧰 Technológiák

- `Java 17`
- `Spring Boot 3`
- `RestTemplate` / `WebClient`
- `DTO` réteg & validáció
- `Framer` frontend integráció
- `CORS` beállítás frontendhez

---

## 🚀 Használat

A backend végpont elérhetősége:


