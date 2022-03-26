echo "Processing..."

set -e
export PGDATABASE="testdb"
export PGHOST="jdbc:postgresql://localhost:5432/${PGDATABASE}"
export PGUSER="postgres"
export PGPASSWORD="password"
set +e

echo "Done!"
