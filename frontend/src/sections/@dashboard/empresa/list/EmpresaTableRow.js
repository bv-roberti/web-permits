import PropTypes from "prop-types";
import { useState } from "react";
// @mui
import { useTheme } from "@mui/material/styles";
import {
  Checkbox,
  TableRow,
  TableCell,
  Typography,
  Stack,
  Link,
  MenuItem,
} from "@mui/material";
// utils
import { fDate } from "../../../../utils/formatTime";
import createAvatar from "../../../../utils/createAvatar";
import { fCurrency } from "../../../../utils/formatNumber";
// components
import Label from "../../../../components/Label";
import Avatar from "../../../../components/Avatar";
import Iconify from "../../../../components/Iconify";
import { TableMoreMenu } from "../../../../components/table";

// ----------------------------------------------------------------------

EmpresaTableRow.propTypes = {
  row: PropTypes.object.isRequired,
  selected: PropTypes.bool,
  onSelectRow: PropTypes.func,
  onViewRow: PropTypes.func,
  onEditRow: PropTypes.func,
  onDeleteRow: PropTypes.func,
};

export default function EmpresaTableRow({
  row,
  selected,
  onSelectRow,
  onViewRow,
  onEditRow,
  onDeleteRow,
}) {
  const theme = useTheme();

  const { name, id, status } = row;

  console.log(row);

  const [openMenu, setOpenMenuActions] = useState(null);

  const handleOpenMenu = (event) => {
    setOpenMenuActions(event.currentTarget);
  };

  const handleCloseMenu = () => {
    setOpenMenuActions(null);
  };

  return (
    <TableRow hover selected={selected}>
      <TableCell padding="checkbox">
        <Checkbox checked={selected} onClick={onSelectRow} />
      </TableCell>

      <TableCell sx={{ display: "flex", alignItems: "center" }}>
        <Stack>
          <Typography variant="subtitle2" noWrap>
            {name}
          </Typography>

          <Link
            noWrap
            variant="body2"
            onClick={onViewRow}
            sx={{ color: "text.disabled", cursor: "pointer" }}
          >
            {`INV-${id}`}
          </Link>
        </Stack>
      </TableCell>

      <TableCell align="left">{fDate(Date())}</TableCell>

      <TableCell align="center">{fCurrency(1)}</TableCell>

      <TableCell align="left">
        <Label
          variant={theme.palette.mode === "light" ? "ghost" : "filled"}
          color={
            (status === "paid" && "success") ||
            (status === "unpaid" && "warning") ||
            (status === "overdue" && "error") ||
            "default"
          }
          sx={{ textTransform: "capitalize" }}
        >
          {status}
        </Label>
      </TableCell>

      <TableCell align="right">
        <TableMoreMenu
          open={openMenu}
          onOpen={handleOpenMenu}
          onClose={handleCloseMenu}
          actions={
            <>
              <MenuItem
                onClick={() => {
                  onDeleteRow();
                  handleCloseMenu();
                }}
                sx={{ color: "error.main" }}
              >
                <Iconify icon={"eva:trash-2-outline"} />
                Excluir
              </MenuItem>

              <MenuItem
                onClick={() => {
                  onViewRow();
                  handleCloseMenu();
                }}
              >
                <Iconify icon={"eva:eye-fill"} />
                Ver
              </MenuItem>

              <MenuItem
                onClick={() => {
                  onEditRow();
                  handleCloseMenu();
                }}
              >
                <Iconify icon={"eva:edit-fill"} />
                Editar
              </MenuItem>
            </>
          }
        />
      </TableCell>
    </TableRow>
  );
}
