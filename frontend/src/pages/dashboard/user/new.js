// @mui
import { Container } from "@mui/material";
// routes
import { PATH_DASHBOARD } from "../../../routes/paths";
// hooks
import useSettings from "../../../hooks/useSettings";
// layouts
import Layout from "../../../layouts";
// components
import Page from "../../../components/Page";
import HeaderBreadcrumbs from "../../../components/HeaderBreadcrumbs";
// sections
import UserNewEditForm from "../../../sections/@dashboard/user/UserNewEditForm";

// ----------------------------------------------------------------------

UserCreate.getLayout = function getLayout(page) {
  return <Layout>{page}</Layout>;
};

// ----------------------------------------------------------------------

export default function UserCreate() {
  const { themeStretch } = useSettings();

  return (
    <Page title="Criar novo usuario">
      <Container maxWidth={themeStretch ? false : "lg"}>
        <HeaderBreadcrumbs
          heading="Adicionar usuario"
          links={[
            { name: "Dashboard", href: PATH_DASHBOARD.root },
            { name: "Usuario", href: PATH_DASHBOARD.user.list },
            { name: "Novo" },
          ]}
        />
        <UserNewEditForm />
      </Container>
    </Page>
  );
}
