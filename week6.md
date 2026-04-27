# Week 6 – Code Review and Design Refinement

## Issue Found
The system returned a value of 0 when a product was not found during impact calculation, which could mislead users.
<img width="480" height="167" alt="image" src="https://github.com/user-attachments/assets/22fc9887-b6c1-4de5-be35-3f4d7dd09ae1" />


## Improvement Implemented
We improved error handling by throwing an exception when a product is not found and handling it in the ConsoleUI.
<img width="555" height="168" alt="image" src="https://github.com/user-attachments/assets/163a962f-9693-4fec-af6c-9048c25b093a" />
<img width="556" height="237" alt="image" src="https://github.com/user-attachments/assets/adc5c821-940a-4f94-9732-c947462442e5" />


## Result
The system now provides clear feedback to the user instead of silently returning incorrect values. This improves usability and correctness.
