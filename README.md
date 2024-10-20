### How to run:
Disclaimer: This repo is just for learning and educative purpose.

1. Clone the repo
2. Run following command from terminal: 
    > `gradle clean test -DparallelCount=2 -Dbrowser=chrome`

### Things yet to implement:
1. SLFJ is not working as of now.
2. "${parallelCount}" when added in testng.xml is giving equivalent to NumberFormatException. Maybe try to use mustache compiler to first replace parallelCount in xml file from cli argument using some gradle task which runs before test task.
3. Extent report.
4. Include demo for grouping annotation.
5. Include demo for data provider.
6. Generate API token on the fly and regenerate token based on expiry.
7. API test support yet to be added.
8. Enhance to use lombok.
9. Check feasibility to add dependency injection.
10. Enhance testng.xml to pick only files from src/test/java based on regex which contain `Test`/`test` literal in filename.