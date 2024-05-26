### DOCKER

### Configuration
- Get into a docker container 
```
    docker exec -it <container_name_or_id> /bin/bash
```

## Database File Layout
- All the data needed for a database cluster is stored within the cluster's data directory,commonly referred to as PGDATA. Multiple clusters, managed by different server instances, can exist on the same machine.

#### PostgreSQL
- Database Physical Storage. A common location for PGDATA is shown below.
```
    cd /var/lib/pgsql/data
```

#### Contents of PGDATA.

- PG_VERSION: A file containing the major version number of PostgreSQL
- base: Subdirectory containing per-database subdirectories
- current_logfiles: File recording the log file(s) currently written to by the logging collector
- global: Subdirectory containing cluster-wide tables, such as pg_database
- pg_commit_ts: Subdirectory containing transaction commit timestamp data
- pg_dynshmem: Subdirectory containing files used by the dynamic shared memory subsystem
- pg_logical: Subdirectory containing status data for logical decoding
- pg_multixact: Subdirectory containing multitransaction status data (used for shared row locks)
- pg_notify: Subdirectory containing LISTEN/NOTIFY status data
- pg_replslot: Subdirectory containing replication slot data
- pg_serial: Subdirectory containing information about committed serializable transactions
- pg_snapshots: Subdirectory containing exported snapshots
- pg_stat: Subdirectory containing permanent files for the statistics subsystem
- pg_stat_tmp: Subdirectory containing temporary files for the statistics subsystem
- pg_subtrans: Subdirectory containing subtransaction status data
- pg_tblspc: Subdirectory containing symbolic links to tablespaces
- pg_twophase: Subdirectory containing state files for prepared transactions
- pg_wal: Subdirectory containing WAL (Write Ahead Log) files
- pg_xact: Subdirectory containing transaction commit status data
- postgresql.auto.conf: A file used for storing configuration parameters that are set by ALTER SYSTEM
- postmaster.opts: A file recording the command-line options the server was last started with
- postmaster.pid: A lock file recording the current postmaster process ID (PID), cluster data directory path, postmaster start timestamp, port number,     Unix-domain socket directory path (could be empty), first valid listen_address (IP address or *, or empty if not listening on TCP), and shared memory segment ID (this file is not present after server shutdown)

* For each database in the cluster there is a subdirectory within PGDATA/base, named after the database's OID in pg_database. This subdirectory is the default location for the database's files; in particular, its system catalogs are stored there.

### More About the structure:
https://www.postgresql.org/docs/current/storage-file-layout.html
