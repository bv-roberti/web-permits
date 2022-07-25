import PropTypes from "prop-types";
import * as Yup from "yup";
import { useCallback, useEffect, useMemo } from "react";
import { useSnackbar } from "notistack";
// next
import { useRouter } from "next/router";
// form
import { useForm, Controller } from "react-hook-form";
import { yupResolver } from "@hookform/resolvers/yup";
// @mui
import { LoadingButton } from "@mui/lab";
import {
  Box,
  Card,
  Grid,
  Stack,
  Switch,
  Typography,
  FormControlLabel,
} from "@mui/material";
// utils
import { fData } from "../../../utils/formatNumber";
// routes
import { PATH_DASHBOARD } from "../../../routes/paths";
// _mock
import { countries } from "../../../_mock";
// components
import Label from "../../../components/Label";
import {
  FormProvider,
  RHFRadioGroup,
  RHFSelect,
  RHFSwitch,
  RHFTextField,
  RHFUploadAvatar,
} from "../../../components/hook-form";

import { UF_LABEL } from "../../../utils/constants";

// ----------------------------------------------------------------------

UserNewEditForm.propTypes = {
  isEdit: PropTypes.bool,
  currentUser: PropTypes.object,
};

export default function UserNewEditForm({ isEdit = false, currentUser }) {
  const { push } = useRouter();

  const { enqueueSnackbar } = useSnackbar();

  const NewUserSchema = Yup.object().shape({
    name: Yup.string().required("Name is required"),
    cnpj: Yup.string().required("cnpj is required"),
    uf: Yup.string().required("UF is required"),
  });

  const defaultValues = useMemo(
    () => ({
      name: currentUser?.name || "",
      cnpj: currentUser?.cnpj || "",
      uf: currentUser?.uf || "",
    }),
    // eslint-disable-next-line react-hooks/exhaustive-deps
    [currentUser]
  );

  const methods = useForm({
    resolver: yupResolver(NewUserSchema),
    defaultValues,
  });

  const {
    reset,
    watch,
    control,
    setValue,
    handleSubmit,
    formState: { isSubmitting },
  } = methods;

  const values = watch();

  useEffect(() => {
    if (isEdit && currentUser) {
      reset(defaultValues);
    }
    if (!isEdit) {
      reset(defaultValues);
    }
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [isEdit, currentUser]);

  const onSubmit = async () => {
    try {
      console.log("sub");
      await new Promise((resolve) => setTimeout(resolve, 500));
      console.log("pro");
      reset();
      enqueueSnackbar(!isEdit ? "Salvo com sucesso!" : "Salvo com sucesso!");
      push(PATH_DASHBOARD.empresa.list);
    } catch (error) {
      console.error(error);
    }
  };

  const handleDrop = useCallback(
    (acceptedFiles) => {
      const file = acceptedFiles[0];

      if (file) {
        setValue(
          "avatarUrl",
          Object.assign(file, {
            preview: URL.createObjectURL(file),
          })
        );
      }
    },
    [setValue]
  );

  return (
    <FormProvider methods={methods} onSubmit={handleSubmit(onSubmit)}>
      <Grid container spacing={3}>
        <Grid item xs={10} md={12}>
          <Card sx={{ p: 3 }}>
            <Box
              sx={{
                display: "grid",
                columnGap: 2,
                rowGap: 3,
                gridTemplateColumns: {
                  xs: "repeat(1, 1fr)",
                  sm: "repeat(2, 1fr)",
                },
              }}
            >
              <RHFTextField name="name" label="Nome" />

              <RHFTextField name="cnpj" label="CNPJ" />

              <RHFSelect name="uf" label="UF" placeholder="UF">
                <option value="" />
                {UF_LABEL.map((option) => (
                  <option key={option.nome} value={option.sigla}>
                    {option.sigla}
                  </option>
                ))}
              </RHFSelect>

              <RHFTextField name="region" label="Regiao" />
              <RHFTextField name="localization" label="Localizacao" />
            </Box>

            <Stack alignItems="flex-end" sx={{ mt: 3 }}>
              <LoadingButton
                type="submit"
                variant="contained"
                loading={isSubmitting}
              >
                {!isEdit ? "Salvar" : "Save Changes"}
              </LoadingButton>
            </Stack>
          </Card>
        </Grid>
      </Grid>
    </FormProvider>
  );
}
