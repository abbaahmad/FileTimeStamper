# FileTimeStamper
Renames files, replaces a placeholder with timestamp values
Renames (migration) files contained in path specified in`<argument>` of the `pom.xml` file matching a specified pattern to 
a timestamp pattern.

## Acceptable Patterns:
V1_x__name_of_migration_file.sql
V11_x__name-of-another-migration-file.sql
V111_X__yet_another-migration-file.sql
R1_xx__yet-a-2-nd_migration-file.sql
U1_XX__a-5-th_migration_file.sql

## Non-acceptable Patterns:
v2__x__non-acceptable_pattern.sql
u3_x_another_non_acceptable_pattern.sql
