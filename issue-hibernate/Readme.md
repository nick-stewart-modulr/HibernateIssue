This small demo replicates an issue when saveAll method is used to save more than 100000 records at once.

The test uses postgres test container, below command can be used to create a postgres  as a container using image `postgres:15-alpine`.
```
docker run --name pg1 -p 5432:5432 -e POSTGRES_USER=mkyong -e POSTGRES_PASSWORD=password -e POSTGRES_DB=mydb -d postgres:15-alpine 
```