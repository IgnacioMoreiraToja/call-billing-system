# Call Billing System

Java project to model and calculate the cost of phone calls (local, national, and international).

## Assumptions

- Call duration is measured in whole minutes (no partial minute billing).
- The system does not handle time zones or daylight saving changes.

### National Calls
- "Localidad" is interpreted as "province/state".
- A limited set of provinces is defined with specific rates:
  - Cordoba: 0.30 per minute
  - Santa Fe: 0.25 per minute
  - Tierra del Fuego: 0.50 per minute
- Any province not explicitly listed uses a default rate of 0.40 per minute.

### International Calls
- A limited set of countries is defined with specific rates:
  - USA: 1.00 per minute
  - Spain: 0.80 per minute
  - Brazil: 0.60 per minute
- Any country not explicitly listed uses a default rate of 0.90 per minute.