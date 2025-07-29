# ☄️ Asteroid Monitor

_Egy modern, Java alapú REST backend szolgáltatás, amely a NASA NEO API-jából nyeri az adatokat._

![Java](https://img.shields.io/badge/-Java-blue?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/-SpringBoot-success?style=for-the-badge)
![REST API](https://img.shields.io/badge/-REST%20API-lightgrey?style=for-the-badge)
![Framer](https://img.shields.io/badge/-Framer-purple?style=for-the-badge)

---

> ⚠️ **Fontos megjegyzés:**
>
> Az alkalmazás frontendje **csak akkor működik webes felületen**, ha a Java backend éppen fut a gépemen.  
> **Postman segítségével viszont a backend funkciók bármikor tesztelhetők**, függetlenül a frontendtől.
> > A `nasa.api.key` értékét a rendszer környezeti változójából (`NASA_API_KEY`) olvassa be.
> 
> **Eclipse használata esetén:**
> - Run → Run Configurations... → Environment → `NASA_API_KEY=kulcsod`

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
**`GET http://localhost:8081/api/asteroids?from=2025-01-01&to=2025-01-02`**

A válasz JSON például:
```json
[
  {
    "name": "162142 (1998 VR)",
    "estimated_diameter_min_meters": 455.57,
    "estimated_diameter_max_meters": 1018.69,
    "relative_velocity_kps": 9.14,
    "is_potentially_hazardous": false
  },
  ...
]



