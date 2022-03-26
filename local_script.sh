echo "Processing..."

set -e
export PGDATABASE="testdb"
export PGHOST="localhost"
export PGPORT=5432
export PGURL="jdbc:postgresql://${PGHOST}:${PGPORT}/${PGDATABASE}"
export PGUSER="postgres"
export PGPASSWORD="password"
set +e

echo "Done!"
