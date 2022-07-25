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
import UserNewEditForm from "../../../sections/@dashboard/empresa/UserNewEditForm";

// ----------------------------------------------------------------------

EmpresaCreate.getLayout = function getLayout(page) {
  return <Layout>{page}</Layout>;
};

// ----------------------------------------------------------------------

export default function EmpresaCreate() {
  const { themeStretch } = useSettings();

  return (
    <Page title="User: Create a new user">
      <Container maxWidth={themeStretch ? false : "lg"}>
        <HeaderBreadcrumbs
          heading="Criar nova empresa"
          links={[
            { name: "Dashboard", href: PATH_DASHBOARD.root },
            { name: "Empresa", href: PATH_DASHBOARD.user.list },
            { name: "Nova empresa" },
          ]}
        />
        <UserNewEditForm />
      </Container>
    </Page>
  );
}
